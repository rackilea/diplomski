StringBuffer buf = new StringBuffer();
buf.append("@Override").append("\n");
buf.append(Modifier.toString(Modifier.PUBLIC) + " ");
buf.append(Signature.toString(method.getSignature(), method.getElementName(), method.getParameterNames(), false, true));
buf.append(" {").append("\n");
buf.append("// the code from the annotation\n");
buf.append("}");