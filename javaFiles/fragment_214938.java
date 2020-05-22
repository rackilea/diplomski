final ListUsingClass listUser = new ListUsingClass(); // or assign to existing reference
saveBtnYes.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listUser.setActivityNames(saveBtnYesFunc(currentYesBtnId));
                 }
            });