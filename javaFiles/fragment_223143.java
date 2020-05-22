if (isEager) {
    fetchMode 'propertyOne', FetchMode.JOIN
    fetchMode 'propertyTwo', FetchMode.JOIN
    fetchMode 'propertyThree', FetchMode.JOIN
    setResultTransformer Criteria.DISTINCT_ROOT_ENTITY
}