@Override
 public String createOrder(OrderMasterTbl order) {
      getHibernateTemplate().saveOrUpdate(order);


      Integer addId=order.getAdType().getId();
      String id = null ;
      if(addId.equals(1)){
          id="ap"+ new SimpleDateFormat("ddMMyyyy").format(newDate())+ap;
          ap++;

      }else{
          id="dp"+new SimpleDateFormat("ddMMyyyy").format(newDate())+dp;
          dp++;
      }

      System.out.print(id);
      order.setOrderCode(id);
      getHibernateTemplate().saveOrUpdate(order);

      return id;
 }