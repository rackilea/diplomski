Table tornados = Table.createFromCsv("data/tornadoes_1950-2014.csv");
tornadoes.setName("tornadoes");

tornados.structure().print();
output:
    Structure of tornadoes_1950-2014.csv
    Index Column Name Column Type 
    0     Date        LOCAL_DATE  
    1     Time        LOCAL_TIME  
    2     State       CATEGORY    
    3     Scale       SHORT_INT   
    4     Injuries    SHORT_INT   
    5     Fatalities  SHORT_INT   
    6     Start Lat   FLOAT       
    7     Start Lon   FLOAT       
    8     Length      FLOAT       
    9     Width       FLOAT    

tornados.shape()
output:
    59945 rows X 10 cols

// gets the month from every date, and counts by month
CategoryColumn month = tornadoes.dateColumn("Date").month();
month.summary();
output:

    Column: Date month
    Category  Count 
    JANUARY   1417  
    MARCH     3935  
    JULY      6305  
    MAY       13072 
    SEPTEMBER 3142  
    OCTOBER   2332  
    DECEMBER  1355  
    NOVEMBER  2364  
    FEBRUARY  1672  
    APRIL     8533  
    AUGUST    4066  
    JUNE      11633 


Table injuriesByScale = tornados.median("Injuries").by("Scale");
output:
    Median injuries by Tornado Scale
    Scale Median [Injuries] 
    -9    0.0               
    0     0.0               
    1     0.0               
    2     0.0               
    3     2.0               
    4     14.0              
    5     141.0             

// query:
Table fatal =  
     tornados.selectWhere(column("Fatalities").isGreaterThan(0));
// sort
Table sorted = tornados.sortOn("State");