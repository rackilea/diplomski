import numpy as np
from urllib.request import urlopen

# The stock to fetch
stock = 'AMD'

# Yahoos API
urlToVisit = 'http://chartapi.finance.yahoo.com/instrument/1.0/'+stock+'/chartdata;type=quote;range=1y/csv'
stockFile = []

# Fetch the stock info from Yahoo API
try:
    sourceCode = urlopen(urlToVisit).read().decode('utf-8')
    splitSource = sourceCode.split('\n')
    for eachLine in splitSource:
        splitLine = eachLine.split(',')
        if len(splitLine)==6:
            if 'values' not in eachLine:
                stockFile.append(eachLine)
except Exception as e:
    print(str(e), 'failed to organize pulled data')

except Exception as e:
    print(str(e), 'failed to pull price data')

date, closep, highp, lowp, openp, volume = np.loadtxt(stockFile, delimiter=',',unpack=True,)


def rsiFunc(prices, n=14):
    # Returns an RSI array
    deltas = np.diff(prices)
    seed = deltas[:n+1]
    up = seed[seed>=0].sum()/n
    down = -seed[seed<0].sum()/n
    rs = up/down
    rsi = np.zeros_like(prices)
    rsi[:n] = 100. - 100./(1.+rs)

    for i in range(n, len(prices)):
        delta = deltas[i-1]
        if delta > 0:
            upval = delta
            downval = 0.
        else:
            upval = 0.
            downval = -delta
        up = (up*(n-1)+upval)/n
        down = (down*(n-1)+downval)/n
        rs = up/down
        rsi[i] = 100. - 100./(1.+rs)
    return rsi


# Lets see what we got here
rsi = rsiFunc(closep)
n = 0
for i in date:
    print('Date stamp:', i, 'RSI', rsi[n])
    n+=1