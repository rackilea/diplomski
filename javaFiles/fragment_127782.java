LifeCycle lifeCycle = ...;

String baseURL = switch (lifeCycle) {
    case Production -> prodUrl;
    case Development -> devUrl;
    case LocalDevelopment -> localDevUrl;
};