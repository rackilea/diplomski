public function getRecordsByInExpression($tableName, $providerCode, $fieldName, $values, $logicalOp = self::IN_EXP)
{
    $queryExp =[
        'TableName' => $tableName,
        'KeyConditionExpression' => 'ProviderCode = :pc',
        'FilterExpression' => $logicalOp == self::IN_EXP ? "$fieldName IN (:list)" : "NOT ($fieldName IN (:list))",
        'ExpressionAttributeValues' => [
            ':pc' => $providerCode,
            ':list' => implode(',', $values)
        ]
    ];

    return $this->query($queryExp)->get('Items');
}