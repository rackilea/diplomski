listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> list, View v, int pos, long id) {
                Intent intent;
                switch (pos) {
                    case 0:
                        intent = new Intent(DrugaStranica.this, TestOneActivity.class);
                        break;
                    case 1:
                        intent = new Intent(DrugaStranica.this, TestTwoActivity.class);
                        break;
                    case 2:
                        intent = new Intent(DrugaStranica.this, TestThreeActivity.class);
                        break;
                    case 3:
                        intent = new Intent(DrugaStranica.this, TestFourActivity.class);
                        break;
                    default:
                        intent = new Intent(DrugaStranica.this, MainActivity.class);
                        break;
                }

                startActivity(intent);
            }

        });