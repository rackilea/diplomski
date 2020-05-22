when(tagDao.findByNameInOrderByName(Matchers.anyListOf(String.class))).thenAnswer(new Answer<List<Tag>>() {
            @Override
            public List<Tag> answer(InvocationOnMock invocationOnMock) throws Throwable {
                Object[] args = invocationOnMock.getArguments();
                List<Tag> tags = new ArrayList<Tag>();
                return tags;
            }
        });