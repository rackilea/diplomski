class MyJsonClass
{
    private String srno;
    private String itemcode;
    private String type;
    private String subtype;
    private String sku;
    private String invqty;
    private String invprice;
    private String discount;
    private String total;

    public String getSrno(){ return srno;}
    public void setSrno(String srno){ this.srno = srno;}
    public String getItemcode(){ return itemcode;}
    public void setItemcode(String itemcode){ this.itemcode = itemcode;}
    public String getType(){ return type;}
    public void setType(String type){ this.type = type;}
    public String getSubtype(){ return subtype;}
    public void setSku(String sku){ this.sku = sku;}
    public String getSku(){ return sku;}
    public void setSubtype(String subtype){ this.subtype = subtype;}
    public String getInvqty(){ return invqty;}
    public void setInvqty(String invqty){ this.invqty = invqty;}
    public String getInvprice(){ return invprice;}
    public void setInvprice(String invprice){ this.invprice = invprice;}
    public String getDiscount(){ return discount;}
    public void setDiscount(String discount){ this.discount = discount;}
    public String getTotal(){ return total;}
    public void setTotal(String total){ this.total = total;}


    @Override
    public String toString()
    {
        StringBuffer stbuf = new StringBuffer();
        stbuf.append("srno : ").append(srno);
        stbuf.append(" itemcode : ").append(itemcode);
        stbuf.append(" type : ").append(type);
        stbuf.append(" subtype : ").append(subtype);
        stbuf.append(" sku : ").append(sku);
        stbuf.append(" invqty : ").append(invqty);
        stbuf.append(" invprice : ").append(invprice);
        stbuf.append(" discount : ").append(discount);
        stbuf.append(" total : ").append(total);

        return stbuf.toString();

    }
}