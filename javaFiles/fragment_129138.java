class User {
        private int id;
        private String firstName;
        private Date registrationDate;

        public User(int id, String firstName, Date registrationDate) {
            this.id = id;
            this.firstName = firstName;
            this.registrationDate = registrationDate;
        }

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public Date getRegistrationDate() {
            return registrationDate;
        }

    }

    DateTimeFormat format = DateTimeFormat.getFormat("MM/dd/yyyy");

    User[] registeredUsers = new User[] { new User(1, "valid", format.parse("01/20/2014")),
            new User(2, "invalid", format.parse("05/20/2013")),
            new User(3, "valid", format.parse("02/20/2014")) };

    ListGridRecord[] registeredUsersRecords = new ListGridRecord[registeredUsers.length];

    for (int i = 0; i < registeredUsers.length; i++) {
        User user = registeredUsers[i];
        ListGridRecord record = new ListGridRecord();
        record.setAttribute("id", user.getId());
        record.setAttribute("firstName", user.getFirstName());
        record.setAttribute("registrationDate", user.getRegistrationDate());
        registeredUsersRecords[i] = record;
    }

    DataSourceDateField registeredDate = new DataSourceDateField("registrationDate", "Date");
    DataSourceTextField firstName = new DataSourceTextField("firstName", "Name");
    DataSourceIntegerField id = new DataSourceIntegerField("id", "ID");
    id.setRequired(true);
    id.setPrimaryKey(true);
    id.setHidden(true);

    DataSource ds = new DataSource();
    ds.setClientOnly(true);
    ds.setFields(id, firstName, registeredDate);
    for (int i = 0; i < registeredUsersRecords.length; i++) {
        ds.addData(registeredUsersRecords[i]);
    }

    final ListGrid registeredUsersListGrid = new ListGrid();

    registeredUsersListGrid.setDataSource(ds);
    registeredUsersListGrid.fetchData();
    registeredUsersListGrid.setShowFilterEditor(true);

    registeredUsersListGrid.addFilterEditorSubmitHandler(new FilterEditorSubmitHandler() {

        @Override
        public void onFilterEditorSubmit(FilterEditorSubmitEvent event) {

            event.cancel();

            if (event.getCriteria() != null) {

                AdvancedCriteria advancedCriteria = event.getCriteria().asAdvancedCriteria();

                // store only single criteria for each field(column)
                Map<String, Criterion> criterions = new HashMap<String, Criterion>();
                for (final Criterion criterion : advancedCriteria.getCriteria()) {

                    System.out.println(criterion.getFieldName());
                    System.out.println(criterion.getValueAsString());
                    System.out.println(criterion.getOperator());

                    if (criterion.getOperator() == OperatorId.ICONTAINS) {
                        Criterion newCritearia = new Criterion(criterion.getFieldName(),
                                OperatorId.STARTS_WITH, criterion.getValueAsString());
                        criterions.put(criterion.getFieldName(), newCritearia);
                    } else {
                        criterions.put(criterion.getFieldName(), criterion);
                    }

                }

                if (criterions.size() > 0) {
                    AdvancedCriteria filterCriteria = new AdvancedCriteria(OperatorId.AND,
                            criterions.values().toArray(new Criterion[] {}));
                    registeredUsersListGrid.fetchData(filterCriteria);
                }

            }

        }
    });

    Button button = new Button("Clear all filters");
    button.addClickHandler(new ClickHandler() {

        @Override
        public void onClick(ClickEvent event) {
            registeredUsersListGrid.fetchData();
        }
    });

    VLayout layout = new VLayout();
    layout.setWidth("200px");
    layout.setHeight("200px");

    layout.addMember(button);
    layout.addMember(registeredUsersListGrid);
    layout.draw();