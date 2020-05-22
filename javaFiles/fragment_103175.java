PUT /agg_index/doc/1
{
  "time": "00:00",
  "child_tag": {
    "300": 100,
    "310": 200
  },
  "master_tag": {
    "1000": 300,
    "1001": 400,
    "1010": 400
  }
}

PUT /agg_index/doc/2
{
  "time": "01:00",
  "child_tag": {
    "300": 500,
    "310": 600
  },
  "master_tag": {
    "1000": 700,
    "1010": 800
  }
}