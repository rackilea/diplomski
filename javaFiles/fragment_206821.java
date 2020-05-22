AjaxButton ok = new AjaxButton("ok") {

        @Override
        protected void onSubmit(AjaxRequestTarget target) {
            result= 2*num;
            target.add(r);
        }