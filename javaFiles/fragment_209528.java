private static class FakeTemplate extends Template {
    @Override
    public String getStartTime() {
        return "invalid date";
    }

    // override other methods as necessary/desired
}

// in your test:
Template fakeTemplate = new FakeTemplate();
templateDAOImpl.saveTemplate(fakeTemplate);