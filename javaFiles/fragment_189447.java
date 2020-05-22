function string.uchar(c, ...)
    if c then
        local t, h, s = {}, 128, string.uchar(...)
        while c >= h do
            t[#t+1] = 128 + c%64
            c = math.floor(c/64)
            h = h > 32 and 32 or h/2
        end
        t[#t+1] = 256 - 2*h + c
        return s.char((table.unpack or unpack)(t)):reverse()..s
    else
        return ''
    end
end