myweights.save(weight, new KinveyClientCallback<WeightEntity>() { 
    public void onSuccess(WeightEntity result){
        myweights.get(new KinveyListCallback<WeightEntity>() { 
            ... 
        }); 

    }
    ... 
});