TransactionTemplate tt = new TransactionTemplate(tm);

...

        this.tt.execute(s -> {
                    template.send(...);
                    template.sendOffsetsToTransaction(...);
                    return null;
                });