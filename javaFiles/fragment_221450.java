class Person:

    name_map = {}

    @classmethod
    def person_from_name(cls, name):
        if name not in cls.name_map:
            cls.name_map[name] = cls(name)
        return cls.name_map[name]

    def __init__(self, name):
        etc...