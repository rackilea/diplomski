import groovy.json.JsonSlurper

// Example Response Data
def restResponse = '[{"uid":10512213, "name":"Bob"},{"uid":7208201, "name":"John"},{"uid":10570, "name":"Jim"},{"uid":1799657, "name":"Sally"}]'

// Parse the response
def list = new JsonSlurper().parseText( restResponse )

// Print them out to make sure
list.each { println it }