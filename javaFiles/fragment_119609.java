require 'sinatra'
require 'json'

post '/echo' do
  content_type "text/plain"
  layout false

  session = JSON.parse request.body.read

  session.map {|k,v| "#{k}: #{v}\n"}
end