import urllib2
import urllib // to make the url request 
import hashlib              //encode it to http
import hmac
import base64      //encording 

request={}
request['command']='listUsers'
request['response']='xml'
request['apikey']='zdfhgsdhfgseahyg'
secretkey='ghfgfgfg'

>>> request
{'apikey': 'plgWJfZK4gyS3mOMTVmjUVg-X-jlWlnfaUJ9GAbBbf9EdM-kAYMmAiLqzzq1ElZLYq_u38zCm0bewzGUdP66mg', 'command': 'listUsers', 'response': 'json'}

>>>request_url="&".join(["=".join([r,urllib.quote_plus(request[r])]) for r in request.keys()])

>>>sig_url="&".join(["=".join([r.lower(),urllib.quote_plus(request[r]).lower()]) for r in sorted(request.iterkeys())])

>>>sig=urllib.quote_plus(base64.encodestring(hmac.new(secretkey,sig_url,hashlib.sha1).digest()).strip())

>>> req=url+request_url+'&signature='+sig
>>> res=urllib2.urlopen(req)
>>> res.read()