for (int i = 0; i < list.size(); i++) {
        String m = 1000000 + (i / 20) + "";
        query = em
                .createQuery("UPDATE OaOnaccount p SET p.status='COMPLETED', p.billingDoc='12112ABCS' WHERE p.crDrIndicator='H' AND p.status ='OPEN' AND p.documentNumber="+ m);
        query.executeUpdate();
        if(i%100==0){// 100 to just to show example-- % operation is costly. you can use better logic to flush. frequent flushing is necessary 
         em.flush();
          }
    }