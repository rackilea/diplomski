{
    "_embedded": {
        "customers": [
            {
                "name": "Minty And Sons Pvt. Ltd.",
                "pan": "5GB7W15M0T",
                "currecny": "INR",
                "tds": 0.1,
                "invoice_prefix": "INV",
                "_links": {
                    "self": {
                        "href": "/customers/1"
                    },
                    "customers": {
                        "href": "/customers"
                    },
                    "contact": {
                        "href": "/customers/1/contact"
                    },
                    "branches": {
                        "href": "/customers/1/branches"
                    },
                    "invoices": {
                        "href": "/customers/1/invoices"
                    },
                    "paid-invoices": {
                        "href": "/customers/1/invoices/paid"
                    },
                    "pending-invoices": {
                        "href": "/customers/1/invoices/pending"
                    },
                    "overdue-invoices": {
                        "href": "/customers/1/invoices/overdue"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/data/api/customers"
        }
    },
    "page": {
        "size": 20,
        "total_elements": 1,
        "total_pages": 1,
        "number": 0
    }
}