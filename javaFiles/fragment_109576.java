if(orderId==null && transactionId ==null) {
        criteria.select(root).where(builder.equal(root.get("merchantId"),merchantId));
    }
    else if(transactionId==null && orderId!=null) {
        criteria.select(root).where(builder.equal(root.get("merchantId"),merchantId),builder.equal(root.get("orderId"),orderId));
    }
    else {
        criteria.select(root).where(builder.equal(root.get("merchantId"),merchantId),builder.equal(root.get("transactionId"),transactionId));
    }