// in this example 'delegate' is w1
Object.metaClass.copyExistentialContents = { 
    def newObj = delegate.class.newInstance()

    delegate.properties.each { prop, val ->
        if (prop in ['metaClass','class']) return
        if (val == null) return

        def newVal = val

        if (val instanceof Collection) {
            newVal = val.findAll { it != null }
        } 

        newObj."${prop}" = newVal 
    }

    return newObj
}