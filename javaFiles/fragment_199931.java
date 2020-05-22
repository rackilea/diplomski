local currentTime = redis.call('TIME');
local list = redis.call('ZRANGEBYSCORE', 'geo-timeout', 0, currentTime[0]);
local keysRemoved = 0;
for i, name in ipairs(list) do
    redis.call('ZREM', 'geo-timeout', name);
    redis.call('ZREM', 'report-geo-set', name);
    keysRemoved = keysRemoved + 1;
end
return keysRemoved;