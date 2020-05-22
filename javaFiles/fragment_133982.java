// The data implements one interface
Data {interface}

// And you implement it with DatabaseData
DbData -> Data
   ...

// Or WebServiceData
WsData -> Data
   ...

// -- DAO part
Dao {interface}
   + fetch(): Data[]

// From database
DatabaseDao -> Dao
    - data: Data[0..*]
    // Query database and create dbData from rows...
    + fetch(): Data[]
        self.status = "Not ok"
        self.status = connectToDb()
        if( self.status == ok ,
            performQuery()
            forEach( row in resultSet,
                data.add( DbData.new( resultSet.next() ) )
            )
            disconnect()
        )
    ...

// From web service
WebServiceDao -> Dao
    - data: Data[0..*]
    // Execute remote method and create wsData from some strange object
    + fetch(): Data[]
        remoteObject: SoapObject = SoapObject()
        remoteObject.connect()
        if (remoteObject.connected?(),
            differentData: StrangeObject = remoteObject.getRemoteData()
            forEach( object in differentData ,
                self.data.add( WsData.new( fromElement ))
            )
        ).else(
           self.status = "Disconnected"
        )
    ....
// -- State part
// Abstract the way the data is going to be retrieved
// either from two sources or from a single one.
FetcheState { abstract }

    - context: Service
    - dao: Dao // Used for a single source

    + doFetch(): Data[] { abstract }

    + setContext( context: Service )
        self.context = context
    + setSingleSource( dao: Dao)
        self.dao = dao

// Fetches only from one DAO, and it doesn't quite merge anything
// because there is only one source after all.
OneSourceState -> FetcheState
   // Use the single DAO and fetch
   + doFetch(): Data[]
       data: Data[] =  self.dao.doFetch()
       // It doesn't hurt to call "context's" merger anyway.
       context.merger.merge( data, null )

// Two sources, are more complex, fetches both DAOs, and validates error.
// If one source had an error, it changes the "state" of the application (context),
// so it can fetch from single source next time.
TwoSourcesState -> FetcheState
    - db: Dao = DatabaseDao.new()
    - ws: Dao = WebServiceDao.new()

    + doFetch(): Data[]
        dbData: Data[] =  db.doFetch()
        wsData: Data[] =  ws.doFetch()

        if( ws.hadError() or db.hadError(),
            // Changes the context's state
            context.fetcher = OneSourceState.new()
            context.merger = OneKindMergeStrategy.new()
            context.fetcher.setContext( self.context )
            // Find out which one was broken
            if( ws.hadError(),
                context.fetcher.setSingleSource( db )
            )
            if( db.hadError(),
                context.fetcher.setSingleSource( ws )
            )
        )
        // Since we have the data already let's 
        // merge it with the "context's" merger.
        return context.merger.merge( dbData, wsData)

// -- Strategy part --
// Encapsulate algoritm to merge data
Strategy{ interface }
    + merge( a: Data[], with : Data[]  )

// One kind doesn't merge too much, just "cast" one array
// because there is only one source after all.
OneKindMergeStrategy -> Strategy
    + merge( a: Data[], b: Data[]  )
         mergedData: Data[]
         forEach( item, in( a ),
            mergedData = Data.new( item ) // Take values from wsData or dbData
         )
         return mergedData

// Two kinds merge, encapsulate the complex algorithm to
// merge data from two sources.
TwoKindsMergeStrategy -> Strategy
    + merge( a: Data[], with: Data[] ): Data[]
        forEach( item, in( a ),
            mergedData: Data[]
            forEach( other, in(with ),
                 WsData wsData = WsData.cast( item )
                 DbData dbData = DbData.cast( other )
                 // Add strange and complex logic here.
                 newItem = Data.new()
                 if( wsData.name == dbData.column.name and etc. etc ,
                    newItem.name = wsData+dbData...e tc. etc
                    ...
                    mergedData.add( newItem )
                 )
            )
        )
        return mergedData

// Finally, the service where the actual fetch is being performed.
Service  { facade }

    - merger: Strategy
    - fetcher: FetcheState

    // Initialise the object with the default "strategy" and the default "state".
    + init()
        self.fetcher  = TwoSourcesState()
        self.merger = TwoKindsMergeStrategy()
        fetcher.setContext( self )

    // Nahh, just let the state do its work.
    + doFetch(): Data[]
        // Fetch using the current application state
        return fetcher.doFetch()