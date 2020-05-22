select strftime('%Y-%m', date), sum(quantity) 
from test
group by strftime('%Y-%m', date);

2011-01    5
2011-02   27
2011-03  133