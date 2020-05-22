import urllib2

url = "https://localhost:8443/EchoWeb/personal/protected"
headers = {
    'Host': 'localhost:8080',
    'User-Agent': 'Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB; rv:1.9.1.3) Gecko/20090824 Firefox/3.5.3',
    'Accept': 'text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8',
    'Accept-Language': 'en-gb,en;q=0.5',
    'Accept-Charset': 'ISO-8859-1,utf-8;q=0.7,*;q=0.7',
    'Cookie' : 'JSESSIONID=9ACCD06B69CA365EFD8C10816ADD8D71'
}
req = urllib2.Request(url, None, headers)
response = urllib2.urlopen(req)
print response.read()