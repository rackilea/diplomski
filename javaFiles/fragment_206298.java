{
    'ruleId': 1000000,
    'Formula': 
    {
        'ruleAggregates': 'foo',
        'fields': ['foo', 'foo'],
        'Children':
        [
            { 
                'Formula':
                {
                    'ruleAggregates': 'a',
                    'fields': ['1', '2'],
                    'Children': []
                }
            },
            {
                'Formula':
                {
                    'ruleAggregates': 'b',
                    'fields': ['3', '4'],
                    'Children': []
                }
            },
            {}
        ]
    }
}