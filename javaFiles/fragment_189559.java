try {
            for (int i = 0; i < keys.size(); i++){

                //See the link for How to use JDO persistence manager on how to use this
                PersistenceManager pm = MyPersistenceManagerClass.getPM();

                //Need to cast it here because it returns an object
                Coupon coupon = (Coupon) pm.getObjectById(Coupon.class, keys.get(i));

                System.out.println("Created by = " + coupon.getCreatedBy());

                System.out.println("Description = " + coupon.getDesc());

                System.out.println("Modified by = " + coupon.getModifiedBy());
            }
        } catch (Exception e){
            e.printStackTrace();
        }