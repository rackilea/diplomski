const headers = {
  'Content-Type': 'text/plain',
}
let someString = 'Example String'
axios.put('/foo/bar', someString, {
    headers: headers
  }).then(resp=>console.log(resp))