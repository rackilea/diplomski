$ curl -s http://localhost:9200/customers_with_addresses/_search | jq '.hits.hits[0]'
{
  "_index": "customers_with_addresses",
  "_type": "type.name=kafkaconnect",
  "_id": "CUSTOMERS_WITH_ADDRESSES+0+2",
  "_score": 1,
  "_source": {
    "ZIP": "76505",
    "CITY": "Temple",
    "ADDRESS_TYPE": "LIVING",
    "CUSTOMER_ID": 1002,
    "FULL_NAME": "Rebeca Kerrod",
    "STATE": "Texas",
    "STREET": "55795 Derek Avenue",
    "LAST_NAME": "Kerrod",
    "FIRST_NAME": "Rebeca"
  }
}