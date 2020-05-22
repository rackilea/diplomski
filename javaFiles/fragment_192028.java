Query query = queryTransform(hql.toString());
    query.setLong("idDocumento", documento.getId());

    return query.list();

}