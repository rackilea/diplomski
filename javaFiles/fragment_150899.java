public List<PayoutDetails> getPayoutDetails(AdvisorReportForm advisorReportForm) {
        Criteria criteria = getSession().createCriteria(PayoutDetails.class);

        if (advisorReportForm.getAdvisorId() != null && advisorReportForm.getAdvisorId() > 0) {
            criteria.add(Restrictions.eq("advisorId", advisorReportForm.getAdvisorId().toString()));
        }

        criteria.createCriteria("payoutHeader")
                .add(Restrictions.between("chequeIssuedDate", advisorReportForm.getFromDate(), advisorReportForm.getToDate()));        

        return criteria.list();
    }