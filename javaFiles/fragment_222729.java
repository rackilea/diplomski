// using core
const api = b$.composeApi({
  nodeHost: "http://at-testnet.burst-alliance.org:6876",
  apiRootUrl: "/burst"
});

api.network.getBlockchainStatus().then(console.log);
// using crypto
console.log(b$crypto.hashSHA256("test"))
// using util
const value = b$util.convertNumberToNQTString(1000)
// using http
const client = new b$http.HttpImpl('https://jsonplaceholder.typicode.com/');
client.get('/todos/1').then(console.log)