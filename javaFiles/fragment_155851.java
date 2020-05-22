static class ExamDataLoader extends LoadableDetachableModel<List<ExamData>> {

        private static final long serialVersionUID = 1L;

        @Override
        protected List<ExamData> load() {
            MySystem mysystem =  MySession.get().getMySystem();
            long userId = mysystem.account(userId).student().id();

            List<String> examsIds = mysystem.exams();
            List<ExamData> exams = new ArrayList<>(examsIds.size());
                for (String exId : mysystem.exams()) {
                    Exam ex = mysystem.exam(exId);
                    if ((!(ex.hasResult(userId) && (ex.isPublished())))) {
                        exams.add(new ExamData(mysystem.account(userId).student().id(), exId));
                    }
                }
                return exams;
            }
        }