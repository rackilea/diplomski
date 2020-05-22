>>> lua_to_python(lua_data)
{'clues': [{'answer': ['ح', 'ر', 'ب', 'ا', 'ء'], 'text': 'حيوان زاحف يغير لون جلده', 'syllables': [['ح', 'ر'], ['ب', 'ا'], ['ء']]}]}
>>> pprint(lua_to_python(lua_data))
{'clues': [{'answer': ['ح', 'ر', 'ب', 'ا', 'ء'],
            'syllables': [['ح', 'ر'], ['ب', 'ا'], ['ء']],
            'text': 'حيوان زاحف يغير لون جلده'}]}