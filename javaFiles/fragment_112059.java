public ArrayList<HashMap<String, String>> convertToFlatFormat(
            JsonNode request) {
        Stack<Pair> stack = new Stack<Pair>();
        ArrayList<HashMap<String, String>> parametersList = new ArrayList<HashMap<String, String>>();
        stack.push(new Pair("", request));
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
        while (!stack.isEmpty()) {
            Pair higherNodePair = stack.pop();
            String nodeName = higherNodePair.name;
            JsonNode higherNode = (JsonNode) higherNodePair.object;
            String newNamePrefix = "";
            if (higherNode.isArray()) {
                ArrayNode higherArrayNode = (ArrayNode) higherNode;
                for (int i = 0; i < higherNode.size(); i++) {
                    JsonNode node = higherArrayNode.get(i);
                    String key = new Integer(i).toString();
                    if (node.isObject()) {
                        if (nodeName.equals("")) {
                            stack.push(new Pair(newNamePrefix, node));
                        } else {
                            stack.push(new Pair(nodeName + "_" + newNamePrefix
                                    , node));
                        }
                    } else if (node.isArray()) {
                        if (nodeName.equals("")) {
                            stack.push(new Pair(newNamePrefix, node));
                        } else {
                            stack.push(new Pair(nodeName + "_" + newNamePrefix
                                    , node));
                        }
                    } else if (node.isValueNode()) {
                        ValueNode valueNode = (ValueNode) node;
                        String value = valueNode.getTextValue();
                        HashMap<String, String> pair = null;
                        if (nodeName.equals("")) {
                            pair = new HashMap<String, String>();
                            pair.put(newNamePrefix + key, value);
                        } else {
                            pair = new HashMap<String, String>();
                            pair.put(nodeName + "_" + newNamePrefix + key,
                                    value);
                        }
                        parametersList.add(pair);
                    }
                }

            } else {
                Iterator<String> iterate = higherNode.getFieldNames();
                while (iterate.hasNext()) {
                    String key = iterate.next();
                    JsonNode node = higherNode.get(key);
                    if (node.isObject()) {
                        if (nodeName.equals("")) {
                            stack.push(new Pair(newNamePrefix + key, node));
                        } else {
                            stack.push(new Pair(nodeName + "_" + newNamePrefix
                                    + key, node));
                        }
                    } else if (node.isArray()) {
                        if (nodeName.equals("")) {
                            stack.push(new Pair(newNamePrefix + key, node));
                        } else {
                            stack.push(new Pair(nodeName + "_" + newNamePrefix
                                    + key, node));
                        }
                    } else if (node.isValueNode()) {
                        ValueNode valueNode = (ValueNode) node;
                        String value = valueNode.getTextValue();
                        HashMap<String, String> pair = null;
                        if (nodeName.equals("")) {
                            pair = new HashMap<String, String>();
                            pair.put(newNamePrefix + key, value);
                        } else {
                            pair = new HashMap<String, String>();
                            pair.put(nodeName + "_" + newNamePrefix + key,
                                    value);
                        }
                        parametersList.add(pair);
                    }
                }
            }
        }
        return parametersList;
    }

    private class Pair {
        public String name;
        public Object object;

        public Pair(String name, Object object) {
            this.name = name;
            this.object = object;
        }
    }