curl -XPOST 'http://127.0.0.1:9200/test/products?pretty=1'  -d '
{
   "locations" : [
      {
         "order" : 1,
         "category" : 5322606
      },
      {
         "order" : 3,
         "subCategory" : null,
         "category" : 5883712
      },
      {
         "order" : 2,
         "subCategory" : 6032961,
         "category" : 5322605
      }
   ],
   "id" : 5331880
}
'