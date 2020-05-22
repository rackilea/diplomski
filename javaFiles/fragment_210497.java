class Logger {
public:
    enum Level {
        ...
    };
    static Logger* Instance();
    void Log(Level level, const char* module, const char* msg);
    void AddModuleFilter(const char* context, const char* module, Level level);
    void SetThreadLocalContext(const char* context);
    ...
};