FunctionExecutor processA=new FunctionExecutor(){
            @Override
            public void execute(Params params) {

                Root.A object=params.getCurrentNode().toObject(Root.A.class);

                // process aClass; save to db. call service etc.
            }
        };
FunctionExecutor processB=new FunctionExecutor(){
            @Override
            public void execute(Params params) {

                Root.B object=params.getCurrentNode().toObject(Root.B.class);

                // process aClass; save to db. call service etc.
            }
        };

FunctionExecutor processC=new FunctionExecutor(){
            @Override
            public void execute(Params params) {

                Root.C object=params.getCurrentNode().toObject(Root.C.class);

                // process aClass; save to db. call service etc.
            }
        };