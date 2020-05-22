ContractAttachment ca = em.createQuery("select ca from ContractAttachment ca " +
        "where ca.contract = :contract and ca.attachment = :attachment")
        .setParameter("contract", selectedContract)
        .setParameter("attachement", selectedAttachment)
        .getSingleResult();
em.remove(ca);