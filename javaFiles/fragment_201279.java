xPathResult = document.evaluate('//comment()', document, null, XPathResult.ANY_TYPE, null);
nodes = [];
node = xPathResult.iterateNext();
while (node) {
    nodes.push(node.textContent);
    node = xPathResult.iterateNext();
}

return nodes;