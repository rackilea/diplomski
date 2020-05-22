public List<PayoutDetails> getPayoutDetails(AdvisorReportForm advisorReportForm) {
        Criteria criteria = getSession().createCriteria(PayoutDetails.class);

        if (advisorReportForm.getAdvisorId() != null && advisorReportForm.getAdvisorId() > 0) {
            criteria.add(Restrictions.eq("advisorId", advisorReportForm.getAdvisorId().toString()));
        }

        criteria.createAlias("payoutHeader", "header")
                .add(Restrictions.between("header.chequeIssuedDate", advisorReportForm.getFromDate(), advisorReportForm.getToDate()));        

        return criteria.list();
    }