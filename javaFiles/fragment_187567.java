@toSend = {
    "name" => "Notch",
    "agent" => "MINECRAFT"
}.to_json

uri = URI.parse("https://api.mojang.com/profiles/page/1")
https = Net::HTTP.new(uri.host,uri.port)
https.use_ssl = true
req = Net::HTTP::Post.new(uri.path, initheader = {'Content-Type' =>'application/json'})
req['foo'] = 'bar'
req.body = "[ #{@toSend} ]"
res = https.request(req)
@debug=  "Response #{res.code} #{res.message}: #{res.body}"