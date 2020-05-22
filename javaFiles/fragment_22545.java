db.collection.aggregate([
    { 
        "$unwind": "$produc" 
    },
    {
        "$match": {
            "produc.cod_zone": "08850"
        }
    },
    {
       "$group":
         {
           "_id": null,
           "produc": { 
               "$push":  { 
                    "cod_prod": "$produc.cod_prod", 
                    "description": "$produc.description",
                    "price" : "$produc.price",
                    "current_stock" : "$produc.current_stock",
                    "min_stock" : "$produc.min_stock",
                    "cod_zone" : "$produc.cod_zone" 
               } 
            }
         }
     },
     {
         "$project": {
             "_id": 0,
             "produc": 1
         }
     }
])