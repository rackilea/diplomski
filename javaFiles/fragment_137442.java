class TestBuilder:
    types = {}

    def __init__(self, uid, name, speed):
        self.uid = uid
        self.name = name
        self.speed = speed
        self.types[name] = self

    @classmethod
    def lookupType(cls, name):
        return cls.types.get(name)