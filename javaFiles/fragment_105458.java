List<TelephoneDetailModel.DataBean> databeans = new ArrayList();

        TelephoneDetailModel.DataBean dataBean = new TelephoneDetailModel.DataBean();
        dataBean.setId("1");
        dataBean.setName("PREM");
        databeans.add(dataBean);


        TelephoneDetailModel.DataBean model1 = new TelephoneDetailModel.DataBean();
        model1.setId("2");
        model1.setName("PREM2");
        databeans.add(model1);


        TelephoneDetailModel.DataBean model2 = new TelephoneDetailModel.DataBean();
        model2.setId("3");
        model2.setName("PREM3");
        databeans.add(model2);


        TelephoneDetailModel.DataBean model3 = new TelephoneDetailModel.DataBean();
        model3.setId("4");
        model3.setName("PREM4");
        databeans.add(model3);


        for (int i = 0; i < databeans.size(); i++) {

            Log.e("ID", databeans.get(i).getId());
            Log.e("NAME", databeans.get(i).getName());
        }