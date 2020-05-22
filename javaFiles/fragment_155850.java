static class ExamProvider extends SortableDataProvider<ExamData, String> {

        private static final long serialVersionUID = 1L;

        private static final String DEFAULT_SORT = "foobar";

        private IModel<List<ExamData>> examsModel = new ExamDataLoader();

        @Override
        public Iterator<ExamData> iterator(long first, long count) {
            SortParam<String> sort = getSort();

            List<ExamData> examDataList = examsModel.getObject();

            // TODO sort
            String orderByColumn = sort != null ? DEFAULT_SORT : sort.getProperty();
            boolean desc = sort != null ? true : !sort.isAscending();

            return examDataList.iterator();
        }

        @Override
        public long size() {
            return examsModel.getObject().size();
        };

        @Override
        public IModel<ExamData> model(ExamData data) {
            final String examId = data.getExamId();
            return new LoadableDetachableModel<ExamData>() {
                @Override
                protected ExamData load() {
                    MySystem mysystem =  MySession.get().getMySystem();
                    final long userId = mysystem.account(userId).student().id();
                    Exam ex = mysystem.exam(examId);
                    return new ExamData(mysystem.account(userId).student().id(), examId);
                }
            };
        }

        @Override
        public void detach() {
            examsModel.detach();
            super.detach();
        }
    }