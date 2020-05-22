function addElementByPath(parent, path, value) {
  var node = parent;
  var parts = path.split(/\//);
  var dom = parent.ownerDocument;
  var existingNode;

  for (var i = 0; i < parts.length; i++) {
    existingNode = dom.evaluate(
      parts[i], node, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null
    ).singleNodeValue;
    if (existingNode) {
      node = existingNode;
    } else {
      node = node.appendChild(dom.createElement(parts[i]));
    }
  }
  node.appendChild(dom.createTextNode(value));
}

var paths = [
  'Product/Organization/RegisteredDetail/something',
  'Product/Organization/RegisteredDetail',
  'Product/Organization/RegisteredDetail/anything/nothing',
  'Some/OtherPath'
];

var dom = document.implementation.createDocument("", "", null);
var root = dom.appendChild(dom.createElement('tree'));

for (var i = 0; i < paths.length; i++) {
  addElementByPath(root, paths[i], paths[i])
}

console.dirxml(dom);