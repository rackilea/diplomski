public Map<Integer, Integer> getItemCodeList(){
    Map<Integer> response = new LinkedHashMap<Integer>();
    response.put(this.item_code1,this.quantity_reqd1);
    response.put(this.item_code2,this.quantity_reqd2);
    response.put(this.item_code3,this.quantity_reqd3);
    response.put(this.item_code4,this.quantity_reqd4);
    response.put(this.item_code5,this.quantity_reqd5);
    return response;