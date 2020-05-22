String inputJsonStr = "[{\"ResponseCode\":1,\"ResponseMsg\":\"[{\"Code\":\"CA2305181\",\"Message\":\"Claim has been added successfully.\"}"
                + "]\"}]";
int indexOfRes = inputJsonStr.indexOf("ResponseMsg");

        if(inputJsonStr.substring(indexOfRes+13,indexOfRes+14).equals("\""))
        {
            inputJsonStr = inputJsonStr.substring(0,indexOfRes+13) + inputJsonStr.substring(indexOfRes+14);
        }
        int indexOfFirstClosingSquare = inputJsonStr.indexOf("]");
        if(inputJsonStr.substring(indexOfFirstClosingSquare+1, indexOfFirstClosingSquare+2).equals("\"")) {
            inputJsonStr = inputJsonStr.substring(0, indexOfFirstClosingSquare+1)+inputJsonStr.substring(indexOfFirstClosingSquare+2);
        }