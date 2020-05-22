//Customer Grid
    def customerGrid = {
        domainClass Customer
        columns
        {
            customer_id
            customer_name
            representative
            'representative.firstName'
            {
                name 'Sales Rep Name'
            }          
        }
    }